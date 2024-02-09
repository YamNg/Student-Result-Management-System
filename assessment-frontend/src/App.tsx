import { Route, Routes } from "react-router-dom";
import HomePage from "./pages/HomePage";
import StudentPage from "./pages/StudentPage";
import CoursePage from "./pages/CoursePage";
import NavMenu from "./components/NavMenu";
import ResultPage from "./pages/ResultPage";
import AddResultPage from "./pages/AddResultPage";
import AddStudentPage from "./pages/AddStudentPage";
import AddCoursePage from "./pages/AddCoursePage";

function App() {
  return (
    <div className="flex">
      <NavMenu />
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/student" element={<StudentPage />} />
        <Route path="/student/add" element={<AddStudentPage />} />
        <Route path="/course" element={<CoursePage />} />
        <Route path="/course/add" element={<AddCoursePage />} />
        <Route path="/result" element={<ResultPage />} />
        <Route path="/result/add" element={<AddResultPage />} />
      </Routes>
    </div>
  );
}

export default App;
