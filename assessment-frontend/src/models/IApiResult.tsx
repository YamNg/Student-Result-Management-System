import { IApiCourse } from "./IApiCourse";
import { IApiStudent } from "./IApiStudent";

// interface declaring property for the api response when retrieving course result entity
export interface IApiResult {
  id: number;
  score: string;
  student: IApiStudent;
  course: IApiCourse;
}
