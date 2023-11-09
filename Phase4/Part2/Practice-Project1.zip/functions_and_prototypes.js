function Employee(name, designation, yearOfBirth){   
    this.name= name; 
    this.designation= designation; 
    this.yearOfBirth= yearOfBirth; 
} 

Employee.prototype.calculateAge= function(){  
    console.log('The current age is: '+(2023- this.yearOfBirth)); 
} 
console.log(Employee.prototype); 

let Emp1= new Employee('Alex', 'Junior Tester', 1995);  
console.log(Emp1) ;
Emp1.calculateAge(); 

let Emp2= new Employee('Dexter', 'Senior Software Developer', 1990); 
console.log(Emp2) 
Emp2.calculateAge();

let Emp3= new Employee('Annie', 'Junior HR', 1998); 
console.log(Emp3) 
Emp3.calculateAge();
