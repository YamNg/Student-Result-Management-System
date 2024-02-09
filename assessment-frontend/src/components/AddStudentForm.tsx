import { useState } from "react";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import { IAddStudentForm } from "../models/IAddStudentForm";
import { subYears } from "date-fns";
import StudentService from "../services/StudentService";
import { toast } from "react-toastify";
import NotificationMessage from "../constant/NotificationMessage";
import { constructErrorMessage } from "../utils/ErrorMessageUtils";

// Form component for adding student
const AddStudentForm = () => {
  const [formData, setFormData] = useState<IAddStudentForm>({
    firstName: "",
    familyName: "",
    dob: subYears(new Date(), 10),
    email: "",
  });

  // set changes to state when user input values
  const handleInputChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setFormData((prevFormData) => ({
      ...prevFormData,
      [e.target.name]: e.target.value,
    }));
  };

  // set changes when user input date in react-datepicker
  const handleDobChange = (date: Date) => {
    setFormData((prevFormData) => ({ ...prevFormData, dob: date }));
  };

  const handleSubmit = async (e: React.FormEvent) => {
    try {
      e.preventDefault();
      await StudentService.addStudent(formData);

      // reset form
      setFormData({
        firstName: "",
        familyName: "",
        dob: subYears(new Date(), 10),
        email: "",
      });

      // show success message
      toast.success(NotificationMessage.REQUEST_SUCCESS);
    } catch (error) {
      // show error message
      constructErrorMessage(error).map((message) => toast.error(message));
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <div>
        <label htmlFor="firstName">First Name:</label>
        <input
          type="text"
          id="firstName"
          name="firstName"
          required
          autoComplete="off"
          onChange={handleInputChange}
          value={formData.firstName}
        />
      </div>

      <div>
        <label htmlFor="familyName">Family Name:</label>
        <input
          type="text"
          id="familyName"
          name="familyName"
          required
          autoComplete="off"
          onChange={handleInputChange}
          value={formData.familyName}
        />
      </div>

      <div>
        <label htmlFor="dob">DOB:</label>
        <DatePicker
          id="dob"
          selected={formData.dob}
          onChange={handleDobChange}
          showYearDropdown
          showMonthDropdown
          maxDate={subYears(new Date(), 10)}
          dropdownMode="select"
          dateFormat="yyyy-MM-dd"
        />
      </div>

      <div>
        <label htmlFor="email">Email:</label>
        <input
          type="email"
          id="email"
          name="email"
          required
          autoComplete="off"
          onChange={handleInputChange}
          value={formData.email}
        />
      </div>

      <div>
        <button type="submit">Submit</button>
      </div>
    </form>
  );
};

export default AddStudentForm;
