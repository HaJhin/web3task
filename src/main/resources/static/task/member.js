console.log("JS OPEN")

function signup() {
    console.log("signup() open")
    const vphoneInput = document.querySelector(".vphoneInput")
    const vcountInput = document.querySelector(".vcountInput")

    if (!vphoneInput || !vcountInput) {
        console.error("입력 필드를 찾을 수 없습니다!");
        return;
    }

    const vphone = vphoneInput.value;
    const vcount = vcountInput.value;

    const info = {vphone : vphone , vcount : vcount}

    const option = {
        method : 'POST' ,
        headers : {'Content-Type' : 'application/json'} ,
        body : JSON.stringify(info)
    }

    fetch('/write.do' , option) 
        .then(r => r.json())
        .then(d => {console.log(d);
            if (d == true) {
                alert("대기 명단 작성 성공!")
                location.href="/list"
            } else {
                alert("대기 명단 작성 실패.")
            }
        })
        .catch(e => {console.log(e);})

        list();
} // f ed

function list() {
    console.log("list() Open")
    
    fetch('/list.do')
        .then(r => r.json())
        .then(d => {console.log(d);
            const list = document.querySelector('.list');

        let html = '';

        for(let i = 0; i < d.length; i++) {
            const lists = d[i];

            html += `<div> 
                순번 : ${lists.vno} , 전화번호 : ${lists.vphone} , 인원수 : ${lists.vcount} 
            </div>`

            list.innerHTML = html;
        }
        })
        .catch(e => {console.log(e)})
}