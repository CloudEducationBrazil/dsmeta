import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";

function DataDatePicker() {
    return (
        <DatePicker
        selected={new Date()}
        onChange={(date: Date) => { }}
        className="dsmeta-form-control"
        dateFormat="dd/MM/yyyy"
    />
    )
  }
  
  export default DataDatePicker
  