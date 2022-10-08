import React,{useState} from 'react'


import './Expenses.css'
import ExpensesList from './ExpensesList';

export default function Expense(props) {
  const [year,setYear] = useState('2020');
  const filterChangeHandler = selectedYear=>{
    setYear(selectedYear)
  }
  const filteredExpenses = props.items.filter(expense=>{
    return expense.date.includes(year);
  })

  return (
    <div>
      <Card className='expenses'>
        <ExpenseFilter selected={year} onChangeFilter={filterChangeHandler} />
        <ExpensesChart expenses={filteredExpenses} />
        <ExpensesList items = {filteredExpenses}/>
      </Card>
    </div>
    
  )
}
