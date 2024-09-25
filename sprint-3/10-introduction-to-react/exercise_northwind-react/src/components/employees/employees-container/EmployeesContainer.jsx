import EmployeesCard from "../employees-card/EmployeesCard"
import "./EmployeesContainer.css"
import { employees } from "../../../data"
import { useState } from "react"


export default function EmployeesContainer() {
    const [selectedEmployee, setSelectedEmployee] = useState(null)

    const employeeSelected = (employee) => {
        setSelectedEmployee(employee);
        console.log(employee);
    }

    return (
        <>
            <main className="container mt-4 employees-container" id="employees-container">
            {selectedEmployee ? (
                    <div className="container mb-5 employee-details">
                        <h3 className="container">Selected Employee: </h3>
                        <img className="img-thumbnail " id="employee-image" src={`images/employees/${selectedEmployee.employeeId}.webp`}/>
                        
                        <h4 className="list-group-item">{selectedEmployee.firstName} {selectedEmployee.lastName}</h4>

                        <li className="list-group-item"><strong>Id: </strong>{selectedEmployee.employeeId}</li>
                        <li className="list-group-item"><strong>Title: </strong>{selectedEmployee.title}</li>
                        <li className="list-group-item"><strong>Salary: $</strong>{selectedEmployee.salary}</li>
                        <li className="list-group-item"><strong>Notes: </strong>{selectedEmployee.notes}</li>
                    </div>
            ) : (

                
                    employees.map((employee) => (
                        <EmployeesCard key={employee.employeeId}
                            employee={employee.firstName + " " + employee.lastName}
                            id={employee.employeeId}
                            title={employee.title}
                            salary={employee.salary}
                            notes={employee.notes}
                            onEmployeeSelected={() => employeeSelected(employee)}
                        ></EmployeesCard>
                    ))
                

            )}
                
               

               

            </main>
        </>
    )

}