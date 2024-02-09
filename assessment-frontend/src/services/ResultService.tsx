import axios from "axios";
import { IApiResponse } from "../models/IApiResponse";
import { IApiResult } from "../models/IApiResult";
import { IAddResultForm } from "../models/IAddResultForm";

const baseUrl = import.meta.env.VITE_RESULT_BASE_URL;

// Service class for Course Result entity to call restful endpoint for CRUD
const getAllResult = async () => {
  const { data }: { data: IApiResponse<IApiResult[]> } = await axios.get(
    baseUrl
  );
  return data.body;
};

const addResult = async (formData: IAddResultForm) => {
  const { data }: { data: IApiResponse<IApiResult> } = await axios.post(
    baseUrl,
    formData
  );
  return data.body;
};

export default { getAllResult, addResult };
