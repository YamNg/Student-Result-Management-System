import { Link } from "react-router-dom";

// Component for navigation bar on the left
const NavMenu = () => {
  return (
    <div className="w-72 h-screen">
      <div className="w-72 h-full bg-gray-950/80 text-white">
        <div className="flex flex-col p-5 gap-5">
          <h1>Menu</h1>
          <nav className="flex flex-col ml-5 gap-5">
            <Link to="/">Home</Link>
            <Link to="/student/add">Add New Students</Link>
            <Link to="/student">Students List</Link>
            <Link to="/course/add">Add New Courses</Link>
            <Link to="/course">Courses List</Link>
            <Link to="/result/add">Add New Results</Link>
            <Link to="/result">Results List</Link>
          </nav>
        </div>
      </div>
    </div>
  );
};

export default NavMenu;
