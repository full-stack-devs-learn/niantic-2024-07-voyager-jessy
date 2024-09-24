import EmployeesCard from "../employees-card/EmployeesCard"
import "./EmployeesContainer.css"
import { employees } from "../../../data"
import { useState } from "react"


export default function EmployeesContainer() 
{
    // const [employees, setEmployees] = useState([]);
    return (
        <>
            <main className="container mt-4 employees-container" id="employees-container">
                {
                    employees.map((employee) => (
                        <EmployeesCard key={employee.employeeId}
                            employee={employee.firstName}
                            id={employee.employeeId}
                            title={employee.title}
                        ></EmployeesCard>
                    ))
                }

            </main>
        </>
    )

}