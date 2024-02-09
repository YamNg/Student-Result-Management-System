import axios from "axios";
import { IApiResponse } from "../models/IApiResponse";
import { IApiStudent } from "../models/IApiStudent";
import { IAddStudentForm } from "../models/IAddStudentForm";

const baseUrl = import.meta.env.VITE_STUDENT_BASE_URL;

// Service class for Student entity to call restful endpoint for CRUD
const getAllStudent = async () => {
  const { data }: { data: IApiResponse<IApiStudent[]> } = await axios.get(
    baseUrl
  );
  return data.body;
};

const deleteStudent = async (studentId: number) => {
  await axios.delete(`${baseUrl}/${studentId}`);
  return studentId;
};

const addStudent = async (formData: IAddStudentForm) => {
  const { dob, ...otherFormFields } = formData;

  const dobString = new Date(dob.getTime() - dob.getTimezoneOffset() * 60000)
    .toISOString()
    .split("T")[0];

  const { data }: { data: IApiResponse<IApiStudent> } = await axios.post(
    baseUrl,
    { dob: dobString, ...otherFormFields }
  );
  return data.body;
};

export default { getAllStudent, deleteStudent, addStudent };
