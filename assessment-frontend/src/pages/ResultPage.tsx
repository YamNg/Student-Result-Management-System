import { useDispatch } from "react-redux";
import ContentSection from "../components/ContentSection";
import { AppDispatch } from "../config/store";
import { useEffect } from "react";
import { initializeResultList } from "../reducers/ResultListReducer";
import ResultList from "../components/ResultList";
import { toast } from "react-toastify";
import { constructErrorMessage } from "../utils/ErrorMessageUtils";

// Page for showing Result data
const ResultPage = () => {
  const dispatch: AppDispatch = useDispatch();

  // initialize redux state for the list of result
  useEffect(() => {
    const fetchData = async () => {
      try {
        await dispatch(initializeResultList());
      } catch (error) {
        constructErrorMessage(error).map((message) => toast.error(message));
      }
    };

    fetchData();
  }, [dispatch]);

  return (
    <>
      <ContentSection>
        <h1>Course Result List</h1>
        <ResultList />
      </ContentSection>
    </>
  );
};

export default ResultPage;
