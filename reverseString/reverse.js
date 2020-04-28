// let stringReverse = (str) => {
//     return str.split('').reverse().join('')
// }



// let stringReverse = (str) => {
//     let reversedString = []
//     let count = 0
//     for (let i = str.length - 1; i >= 0; i--) {
//         reversedString[count] = str[i]
//         count++
//     }

//     return reversedString.join('')
// }



class Stack {
    constructor() {
        this.stack = []
    }

    push(item) {
        return this.stack.push(item)
    }

    pop() {
        return this.stack.pop()
    }
    
    peek() {
        return this.stack[this.stack.length - 1]
    }

    isEmpty() {
        return this.stack.length === 0;
    }

    printStack() {
        return this.stack.join('')
    }
}

let stringReverse = (str) => {
    let letters = str.split('')
    let stack = new Stack()
    let reversedString = []

    letters.forEach(letter => stack.push(letter))

    while(!stack.isEmpty()) {
        reversedString.push(stack.pop())
    }

    return reversedString.join('')
}

console.log(stringReverse('testing'))