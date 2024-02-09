import { Dispatch, createSlice } from "@reduxjs/toolkit";
import CourseService from "../services/CourseService";
import { IApiCourse } from "../models/IApiCourse";
import { IComponentCourseList } from "../models/IComponentCourseList";

// Reducer for courseList
const courseListSlice = createSlice({
  name: "courseList",
  initialState: {
    data: [] as IApiCourse[],
  } as IComponentCourseList,
  reducers: {
    setCourseList(state, action) {
      return {
        ...state,
        data: action.payload,
      };
    },
    removeCourseFromList(state, action) {
      return {
        ...state,
        data: state.data.filter((course) => course.id !== action.payload),
      };
    },
  },
});

export const { setCourseList, removeCourseFromList } = courseListSlice.actions;

// redux thunks for doing data retrieval as well as dispatch action to reducer
export const initializeCourseList = () => {
  return async (dispatch: Dispatch) => {
    const courseList = await CourseService.getAllCourse();
    dispatch(setCourseList(courseList));
  };
};

export const deleteCourse = (courseId: number) => {
  return async (dispatch: Dispatch) => {
    await CourseService.deleteCourse(courseId);
    dispatch(removeCourseFromList(courseId));
  };
};

export default courseListSlice.reducer;
