let limit = 5;
let offset = 0;
let searcher = {}

function getTable() {
    const urlOptions = searcher.search ? '' : `?limit=${limit}&offset=${offset}`
    SheetDB.read(`https://sheetdb.io/api/v1/3eknhbenitewj${urlOptions}`,{casesensitive:false, ...searcher}).then((result)=>{
        console.log(result)
        let tabla = document.getElementById('data-sheet')
        tabla.innerHTML = '' 
        result.forEach(element => {
            tabla.innerHTML += `<tr> <td>${element.Material}</td> <td>${element['Texto breve de material']}</td> <td>${element['Ce.']}</td> <td>${element.UMB}</td> 
            <td>${element['Libre utilización']}</td> </tr>`
        });
    },(error)=>{
        console.log(error)
    })
}

getTable();

function nextAndPrevious(step) {
    if(step === -1 && offset === 0){
        return
    }
    offset = offset + (limit*step)
    getTable();
}

function search() {
    let searchInput = document.getElementById('search');
    let select = document.getElementById('select-search');
    if (searchInput.value) {
        searcher = {
            search:{[select.value]:`*${searchInput.value}*`} 
        }
    } else {
        searcher = {} 
    }
    getTable();
}

/*Button con Enter*/

function submit(e) {
    if (e.code === 'Enter') {
        document.getElementById('submit').click();
    }
}

document.getElementById("submit").onclick = function() {
    search();
}