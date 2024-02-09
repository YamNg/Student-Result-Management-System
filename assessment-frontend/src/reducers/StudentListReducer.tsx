import { Dispatch, createSlice } from "@reduxjs/toolkit";
import { IApiStudent } from "../models/IApiStudent";
import { IComponentStudentList } from "../models/IComponentStudentList";
import StudentService from "../services/StudentService";

// Reducer for studentList
const studentListSlice = createSlice({
  name: "studentList",
  initialState: {
    data: [] as IApiStudent[],
  } as IComponentStudentList,
  reducers: {
    setStudentList(state, action) {
      return {
        ...state,
        data: action.payload,
      };
    },
    removeStudentFromList(state, action) {
      return {
        ...state,
        data: state.data.filter((student) => student.id !== action.payload),
      };
    },
  },
});

export const { setStudentList, removeStudentFromList } =
  studentListSlice.actions;

// redux thunks for doing data retrieval as well as dispatch action to reducer
export const initializeStudentList = () => {
  return async (dispatch: Dispatch) => {
    const studentList = await StudentService.getAllStudent();
    dispatch(setStudentList(studentList));
  };
};

export const deleteStudent = (studentId: number) => {
  return async (dispatch: Dispatch) => {
    await StudentService.deleteStudent(studentId);
    dispatch(removeStudentFromList(studentId));
  };
};

export default studentListSlice.reducer;
