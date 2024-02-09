import { useState } from "react";
import { IAddCourseForm } from "../models/IAddCourseForm";
import CourseService from "../services/CourseService";
import { toast } from "react-toastify";
import NotificationMessage from "../constant/NotificationMessage";
import { constructErrorMessage } from "../utils/ErrorMessageUtils";

// Form component for adding course
const AddCourseForm = () => {
  const [formData, setFormData] = useState<IAddCourseForm>({
    courseName: "",
  });

  // set changes to state when user input values
  const handleInputChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setFormData((prevFormData) => ({
      ...prevFormData,
      [e.target.name]: e.target.value,
    }));
  };

  const handleSubmit = async (e: React.FormEvent) => {
    try {
      e.preventDefault();
      await CourseService.addCourse(formData);

      // reset form
      setFormData({
        courseName: "",
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
        <label htmlFor="courseName">Course Name:</label>
        <input
          type="text"
          id="courseName"
          name="courseName"
          autoComplete="off"
          onChange={handleInputChange}
          value={formData.courseName}
        />
      </div>

      <div>
        <button type="submit">Submit</button>
      </div>
    </form>
  );
};

export default AddCourseForm;
