import './EmployeesCard.css'


export default function EmployeesCard({ id, employee, title, onEmployeeSelected }) {
    const imageUrl = `images/employees/${id}.webp`

    const clickedEmployee = () => {
        onEmployeeSelected(employee)
    }

    return (
        <div className="employee-row" onClick={clickedEmployee}>
            <img id="employee-image" src={imageUrl} />
            <div className="employee-name">
                <h1>{employee}</h1>
                <h6>{title}</h6>
            </div>
        </div>

    );
}