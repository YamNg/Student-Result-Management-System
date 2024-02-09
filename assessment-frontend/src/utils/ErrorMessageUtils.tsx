import { AxiosError } from "axios";
import NotificationMessage from "../constant/NotificationMessage";

// Util to construct error message, which look for the error code return by backend
const constructErrorMessage = (error: unknown) => {
  if (error instanceof AxiosError) {
    // custom error thrown by backend, which will add a list of error code when validation
    if (error.response?.data?.errorCode) {
      const errorCodeString: string = error.response.data.errorCode;
      const errorCodeArr: string[] = errorCodeString.split(",");
      return errorCodeArr.map(
        (errorCode) =>
          NotificationMessage[errorCode as keyof typeof NotificationMessage]
      );
    }
  }

  return [NotificationMessage.INTERNAL_SERVER_ERROR];
};

export { constructErrorMessage };
