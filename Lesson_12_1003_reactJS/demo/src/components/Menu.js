import React from 'react';
import Recipes from './Recipes'
export default function Menu(props) {
    return (
      <article>
        <header>
          <h1>{props.title}</h1>
        </header>
        <div className="recipes">
            {props.recipes.map((recipe,i)=>(
                <Recipes key = {i} {...recipe}/>
            ))}
        </div>

      </article>
    );
}
