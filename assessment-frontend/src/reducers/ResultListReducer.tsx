import { Dispatch, createSlice } from "@reduxjs/toolkit";
import ResultService from "../services/ResultService";
import { IApiResult } from "../models/IApiResult";
import { IComponentResultList } from "../models/IComponentResultList";

// Reducer for resultList
const resultListSlice = createSlice({
  name: "resultList",
  initialState: {
    data: [] as IApiResult[],
  } as IComponentResultList,
  reducers: {
    setResultList(state, action) {
      return {
        ...state,
        data: action.payload,
      };
    },
  },
});

export const { setResultList } = resultListSlice.actions;

// redux thunks for doing data retrieval as well as dispatch action to reducer
export const initializeResultList = () => {
  return async (dispatch: Dispatch) => {
    const resultList = await ResultService.getAllResult();
    dispatch(setResultList(resultList));
  };
};

export default resultListSlice.reducer;
