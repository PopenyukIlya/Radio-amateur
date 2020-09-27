   let data=$.ajax({
        url: "http://localhost:8080/category",
        // dataType: "json", // Для использования JSON формата получаемых данных
        method: "GET", // Что бы воспользоваться POST методом, меняем данную строку на POST
        success: function(data) {
            console.log(data); // Возвращаемые данные выводим в консоль
        }
    });
console.log(data)