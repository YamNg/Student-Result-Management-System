import { useSelector } from "react-redux";
import { IComponentResultList } from "../models/IComponentResultList";

// Component for showing Course Result list
const ResultList = () => {
  // Get pre-initialized list from redux state
  const resultListDataState = useSelector(
    ({ resultList }: { resultList: IComponentResultList }) => {
      return resultList.data;
    }
  );

  return (
    <div className="flexTable">
      <div className="flexTableRow">
        <div className="flexTableCell flex-1">Course</div>
        <div className="flexTableCell flex-1">Student</div>
        <div className="flexTableCell flex-1">Score</div>
      </div>
      {resultListDataState.map((result) => (
        <div key={result.id} className="flexTableRow">
          <div className="flexTableCell flex-1">{result.course.courseName}</div>
          <div className="flexTableCell flex-1">
            {result.student.firstName} {result.student.familyName}
          </div>
          <div className="flexTableCell flex-1">{result.score}</div>
        </div>
      ))}
    </div>
  );
};

export default ResultList;
