// Generic api response received from the backend, which have a Generic type T for the actual data returned by api
export interface IApiResponse<T> {
  status: string;
  body?: T;
  errorCode?: string;
  errorMsg?: string;
}
