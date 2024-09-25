import EmployeesContainer from '../employees-container/EmployeesContainer'
import './EmployeesPage.css'

export default function EmployeesPage() {

    return (
        <>
            <header className="container mt-4">
                <h1>Employees</h1>
            </header>

            <EmployeesContainer></EmployeesContainer>
        </>
    )
}