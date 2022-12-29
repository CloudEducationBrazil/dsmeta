import icon from "../../assets/img/notification-icon.svg";
import "./styles.css";
import axios from "axios";
import { BASE_URL } from "../../utils/request";

type Props = {
    saleId: number;
}

function handleClick(saleId: number){
    axios.get(`${BASE_URL}/sales/${saleId}/notification`).then(response => {
        console.log('Enviada com Sucesso...');
    }); 
}

function NotificationButton( {saleId} : Props) {
    return (
        <div className="dsmeta-red-btn-container" onClick={() => handleClick(saleId)}>
            <img src={icon} alt="Notificar" />
        </div>
    )
  }
  
  export default NotificationButton;
  