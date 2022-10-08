import React from 'react'
import './ExpensesList.css'
import ExpenseItem from './ExpenseItem'
export default function ExpensesList(props) {

  if(props.items.length===0){
    return (
        <h2 className='expenses-list__failure'>
            Found no expenses
        </h2>
    )
  }
  return (
    <ul className='expenses-list'>
     {props.items.map((expense)=>{
        return (
            <ExpenseItem
            key={expense.id}
            title={expense.title}
            amount={expense.amount}
            date={expense.date}
            />
        )
     })}
    </ul>
  )
}
