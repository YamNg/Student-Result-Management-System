import AddCourseForm from "../components/AddCourseForm";
import ContentSection from "../components/ContentSection";

// Page for adding Course data
const AddCoursePage = () => {
  return (
    <>
      <ContentSection>
        <h1>Add Course</h1>
        <AddCourseForm />
      </ContentSection>
    </>
  );
};

export default AddCoursePage;
