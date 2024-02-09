import axios from "axios";
import { IApiResponse } from "../models/IApiResponse";
import { IApiCourse } from "../models/IApiCourse";
import { IAddCourseForm } from "../models/IAddCourseForm";

const baseUrl = import.meta.env.VITE_COURSE_BASE_URL;

// Service class for Course entity to call restful endpoint for CRUD
const getAllCourse = async () => {
  const { data }: { data: IApiResponse<IApiCourse[]> } = await axios.get(
    baseUrl
  );
  return data.body;
};

const deleteCourse = async (courseId: number) => {
  await axios.delete(`${baseUrl}/${courseId}`);
  return courseId;
};

const addCourse = async (formData: IAddCourseForm) => {
  const { data }: { data: IApiResponse<IApiCourse> } = await axios.post(
    baseUrl,
    formData
  );
  return data.body;
};

export default { getAllCourse, deleteCourse, addCourse };
