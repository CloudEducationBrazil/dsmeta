import { useState } from "react";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";

function DataDatePicker() {
    const max = new Date();
    const [maxDate, setMaxDate] = useState(max);

    return (
        <DatePicker
        selected={maxDate}
        onChange={(date: Date) => setMaxDate(date)}
        className="dsmeta-form-control"
        dateFormat="dd/MM/yyyy"
    />
    )
  }
  
  export default DataDatePicker
  