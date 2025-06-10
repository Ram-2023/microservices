import axios from "axios";

const EMPLOYEE_API_BASE_URL = "http://localhost:9191/v1/employees";

const EMPLOYEE_ID = 1;

class EmployeeService {
    getEmployee() {
        return axios.get(EMPLOYEE_API_BASE_URL + "/" + EMPLOYEE_ID);
    }
}

export default new EmployeeService;