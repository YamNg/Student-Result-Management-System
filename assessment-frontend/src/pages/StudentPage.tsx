import { useDispatch } from "react-redux";
import ContentSection from "../components/ContentSection";
import StudentList from "../components/StudentList";
import { AppDispatch } from "../config/store";
import { useEffect } from "react";
import { initializeStudentList } from "../reducers/StudentListReducer";
import { toast } from "react-toastify";
import { constructErrorMessage } from "../utils/ErrorMessageUtils";

// Page for showing student data
const StudentPage = () => {
  const dispatch: AppDispatch = useDispatch();

  // initialize redux state for the list of student
  useEffect(() => {
    const fetchData = async () => {
      try {
        await dispatch(initializeStudentList());
      } catch (error) {
        constructErrorMessage(error).map((message) => toast.error(message));
      }
    };

    fetchData();
  }, [dispatch]);

  return (
    <>
      <ContentSection>
        <h1>Student List</h1>
        <StudentList />
      </ContentSection>
    </>
  );
};

export default StudentPage;
