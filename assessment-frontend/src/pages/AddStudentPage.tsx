import AddStudentForm from "../components/AddStudentForm";
import ContentSection from "../components/ContentSection";

// Page for adding Student data
const AddStudentPage = () => {
  return (
    <>
      <ContentSection>
        <h1>Add Student</h1>
        <AddStudentForm />
      </ContentSection>
    </>
  );
};

export default AddStudentPage;
