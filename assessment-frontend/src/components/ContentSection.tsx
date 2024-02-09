import { ReactNode } from "react";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

// wrapper component for the content section, which show on the right of the screen
const ContentSection = ({ children }: { children: ReactNode }) => {
  return (
    <div className="grow m-5">
      <ToastContainer theme="colored" />
      {children}
    </div>
  );
};

export default ContentSection;
