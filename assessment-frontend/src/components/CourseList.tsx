import { useDispatch, useSelector } from "react-redux";
import { AppDispatch } from "../config/store";
import { RxCrossCircled } from "react-icons/rx";
import { IconContext } from "react-icons";
import { IComponentCourseList } from "../models/IComponentCourseList";
import { deleteCourse } from "../reducers/CourseListReducer";
import { toast } from "react-toastify";
import { constructErrorMessage } from "../utils/ErrorMessageUtils";
import NotificationMessage from "../constant/NotificationMessage";

// Component to show list of courses
const CourseList = () => {
  const dispatch: AppDispatch = useDispatch();

  // Get pre-initialized list from redux state
  const courseListDataState = useSelector(
    ({ courseList }: { courseList: IComponentCourseList }) => {
      return courseList.data;
    }
  );

  // function to handle delete action
  const handleDeleteOnClick = async (id: number) => {
    try {
      // dispatch to reducer
      await dispatch(deleteCourse(id));
      // show success message
      toast.success(NotificationMessage.REQUEST_SUCCESS);
    } catch (error) {
      // show error message
      constructErrorMessage(error).map((message) => toast.error(message));
    }
  };

  return (
    <div className="flexTable">
      <div className="flexTableRow">
        <div className="flexTableCell flex-1">Course Name</div>
        <div className="flexTableCell flex-none w-16">Delete</div>
      </div>
      {courseListDataState.map((course) => (
        <div key={course.id} className="flexTableRow">
          <div className="flexTableCell flex-1">{course.courseName}</div>
          <div
            className="flexTableCell flex-none w-16"
            onClick={() => handleDeleteOnClick(course.id)}
          >
            <IconContext.Provider value={{ className: "icon" }}>
              <RxCrossCircled size={25} />
            </IconContext.Provider>
          </div>
        </div>
      ))}
    </div>
  );
};

export default CourseList;
