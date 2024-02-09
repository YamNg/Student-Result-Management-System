import { useEffect, useState } from "react";
import { IAddResultForm } from "../models/IAddResultForm";
import StudentService from "../services/StudentService";
import { IApiStudent } from "../models/IApiStudent";
import { IApiCourse } from "../models/IApiCourse";
import CourseService from "../services/CourseService";
import ResultService from "../services/ResultService";
import { toast } from "react-toastify";
import NotificationMessage from "../constant/NotificationMessage";
import { constructErrorMessage } from "../utils/ErrorMessageUtils";

// Form component for adding course result
const AddResultForm = () => {
  const [formData, setFormData] = useState<IAddResultForm>({
    studentId: 0,
    courseId: 0,
    score: "",
  });
  const [studentList, setStudentList] = useState<IApiStudent[]>([]);
  const [courseList, setCourseList] = useState<IApiCourse[]>([]);
  const scoreList = ["A", "B", "C", "D", "E", "F"];

  // initialize dropdown values
  useEffect(() => {
    initializeDropdowns();
  }, []);

  const initializeDropdowns = async () => {
    const apiStudentList = (await StudentService.getAllStudent()) ?? [];
    const apiCourseList = (await CourseService.getAllCourse()) ?? [];
    setStudentList(apiStudentList);
    setCourseList(apiCourseList);
  };

  // set changes to state when user select values
  const handleSelectChange = (e: React.ChangeEvent<HTMLSelectElement>) => {
    setFormData((prevFormData) => ({
      ...prevFormData,
      [e.target.name]: e.target.value,
    }));
  };

  const handleSubmit = async (e: React.FormEvent) => {
    try {
      e.preventDefault();
      await ResultService.addResult(formData);

      // reset form
      setFormData({
        studentId: 0,
        courseId: 0,
        score: "",
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
        <label htmlFor="studentId">Student:</label>
        <select
          id="studentId"
          name="studentId"
          onChange={handleSelectChange}
          value={formData.studentId}
        >
          <option disabled value="0">
            -- select an option --
          </option>
          {studentList.map((student) => (
            <option key={student.id} value={student.id}>
              {student.firstName} {student.familyName}
            </option>
          ))}
        </select>
      </div>

      <div>
        <label htmlFor="courseId">Course:</label>
        <select
          id="courseId"
          name="courseId"
          onChange={handleSelectChange}
          value={formData.courseId}
        >
          <option disabled value="0">
            -- select an option --
          </option>
          {courseList.map((course) => (
            <option key={course.id} value={course.id}>
              {course.courseName}
            </option>
          ))}
        </select>
      </div>

      <div>
        <label htmlFor="score">Score:</label>
        <select
          id="score"
          name="score"
          onChange={handleSelectChange}
          value={formData.score}
        >
          <option disabled value="">
            -- select an option --
          </option>
          {scoreList.map((score) => (
            <option key={score} value={score}>
              {score}
            </option>
          ))}
        </select>
      </div>

      <div>
        <button type="submit">Submit</button>
      </div>
    </form>
  );
};

export default AddResultForm;
