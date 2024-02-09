// mapping of backend error code to frontend display error
const NotificationMessage = {
  // ERROR Message
  INTERNAL_SERVER_ERROR: "Internal Server Error",
  UNEXPECTED_SYSTEM_ERROR: "Internal Server Error",

  INVALID_STUDENT_ID: "Please input valid student",
  INVALID_STUDENT_FIRSTNAME: "Please input valid first name",
  INVALID_STUDENT_FAMILYNAME: "Please input valid family name",
  INVALID_STUDENT_DOB: "Please input valid date of birth",
  INVALID_STUDENT_EMAIL: "Please input valid email",

  INVALID_COURSE_ID: "Please input valid course",
  INVALID_COURSE_NAME: "Please input valid course name",

  INVALID_RESULT_SCORE: "Please input valid course result score",
  DATA_RESULT_EXISTS: "Course result already exists",

  // SUCCESS Message
  REQUEST_SUCCESS: "Request Success",
};

export default NotificationMessage;
