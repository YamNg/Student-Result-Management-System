import { configureStore } from "@reduxjs/toolkit";
import StudentListReducer from "../reducers/StudentListReducer";
import CourseListReducer from "../reducers/CourseListReducer";
import ResultListReducer from "../reducers/ResultListReducer";

// Configuration for reducers
const store = configureStore({
  reducer: {
    studentList: StudentListReducer,
    courseList: CourseListReducer,
    resultList: ResultListReducer,
  },
});

export default store;
export type AppDispatch = typeof store.dispatch;
