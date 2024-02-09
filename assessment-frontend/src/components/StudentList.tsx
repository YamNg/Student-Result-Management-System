import { useDispatch, useSelector } from "react-redux";
import { AppDispatch } from "../config/store";
import { IComponentStudentList } from "../models/IComponentStudentList";
import { RxCrossCircled } from "react-icons/rx";
import { IconContext } from "react-icons";
import { deleteStudent } from "../reducers/StudentListReducer";
import { toast } from "react-toastify";
import { constructErrorMessage } from "../utils/ErrorMessageUtils";
import NotificationMessage from "../constant/NotificationMessage";

// Component for showing student list
const StudentList = () => {
  const dispatch: AppDispatch = useDispatch();

  // Get pre-initialized list from redux state
  const studentListDataState = useSelector(
    ({ studentList }: { studentList: IComponentStudentList }) => {
      return studentList.data;
    }
  );

  // function to handle delete action
  const handleDeleteOnClick = async (id: number) => {
    try {
      // dispatch to reducer
      await dispatch(deleteStudent(id));
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
        <div className="flexTableCell flex-1">Name & Family name</div>
        <div className="flexTableCell flex-1">DOB</div>
        <div className="flexTableCell flex-1">Email</div>
        <div className="flexTableCell flex-none w-16">Delete</div>
      </div>
      {studentListDataState.map((student) => (
        <div key={student.id} className="flexTableRow">
          <div className="flexTableCell flex-1">
            {student.firstName} {student.familyName}
          </div>
          <div className="flexTableCell flex-1">{student.dob}</div>
          <div className="flexTableCell flex-1">{student.email}</div>
          <div
            className="flexTableCell flex-none w-16"
            onClick={() => handleDeleteOnClick(student.id)}
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

export default StudentList;
