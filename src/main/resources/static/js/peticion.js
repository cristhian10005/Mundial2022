fetch('https://jsonplaceholder.typicode.com/albums')
  .then(response => response.json())
  .then(data => console.log(data));