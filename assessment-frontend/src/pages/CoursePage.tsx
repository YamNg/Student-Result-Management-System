import { useDispatch } from "react-redux";
import ContentSection from "../components/ContentSection";
import { AppDispatch } from "../config/store";
import { useEffect } from "react";
import { initializeCourseList } from "../reducers/CourseListReducer";
import CourseList from "../components/CourseList";
import { toast } from "react-toastify";
import { constructErrorMessage } from "../utils/ErrorMessageUtils";

// Page for showing Course data
const CoursePage = () => {
  const dispatch: AppDispatch = useDispatch();

  // initialize redux state for the list of courses
  useEffect(() => {
    const fetchData = async () => {
      try {
        await dispatch(initializeCourseList());
      } catch (error) {
        constructErrorMessage(error).map((message) => toast.error(message));
      }
    };

    fetchData();
  }, [dispatch]);

  return (
    <>
      <ContentSection>
        <h1>Course List</h1>
        <CourseList />
      </ContentSection>
    </>
  );
};

export default CoursePage;
