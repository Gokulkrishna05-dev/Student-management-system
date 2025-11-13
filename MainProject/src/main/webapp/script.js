/**
 * 
 */

// Forms
let admin = document.querySelector(".admin");
let adminInfo = document.querySelector(".info-box")
let student = document.querySelector(".student");
let studentinfo = document.querySelector(".info-box-std")
// Form choose btns
let adminLogin = document.querySelector(".alogin");
let StduentLogin = document.querySelector(".slogin");
let val = false;
window.addEventListener("DOMContentLoaded", (() => {
    if (adminLogin || StduentLogin) {
        adminLogin.addEventListener("click", (() => {
            admin.style.display = "block"
            adminInfo.style.display = "block"
            student.style.display = "none"
            studentinfo.style.display = "none"
        }))

        StduentLogin.addEventListener("click", (() => {
            admin.style.display = "none"
            adminInfo.style.display = "none"
            student.style.display = "block"
            studentinfo.style.display = "block"
        }))
    }
}))

// Admin Form Validation

let adminSection = document.querySelector(".admin-section")
let name = document.getElementById("i-aname");
let anet = document.getElementById("i-anet");
let apass = document.getElementById("i-apass");



// Admin errors
let namerr = document.querySelector(".aname")
let neterr = document.querySelector(".net")
let passerr = document.querySelector(".pass")
window.addEventListener("DOMContentLoaded", (() => {
    if (admin) {
        admin.addEventListener("submit", ((e) => {
            let i = NameValidate();
            let j = NetValidate();
            let k = PassValidate();
            let sum = i + j + k;
            if (sum != 3) {
                e.preventDefault()
            }
        }))
    }
}))
function NameValidate() {
    if (name.value == "") {
        namerr.style.display = "block"
        return 0;
    }
    namerr.style.display = "none"
    return 1;
}
function NetValidate() {
    if (anet.value == "") {
        neterr.style.display = "block"
        return 0;
    }
    neterr.style.display = "none"
    return 1;
}
function PassValidate() {
    if (apass.value == "") {
        passerr.style.display = "block"
        return 0;
    }
    passerr.style.display = "none"
    return 1;
}

// Student Form Validation
let snet = document.getElementById("i-snet")
let spass = document.getElementById("i-spass")

let snerr = document.querySelector(".snet")
let sperr = document.querySelector(".spass")
window.addEventListener("DOMContentLoaded", (() => {
    if (student) {
        student.addEventListener("submit", ((e) => {
            let i = SnetValidate()
            let j = spassValidate();
            if (i + j != 2) {
                e.preventDefault();
            }
        }))
    }
}))

function SnetValidate() {
    if (snet.value == "") {
        snerr.style.display = "block"
        return 0;
    }
    snerr.style.display = "none"
    return 1;
}
function spassValidate() {
    if (spass.value == "") {
        sperr.style.display = "block"
        return 0;
    }
    sperr.style.display = "none"
    return 1;
}

// Adding student
let addName = document.getElementById("addname")
let Sname = document.getElementById("Lname")
let regno = document.getElementById("regno")
let dept = document.getElementById("dept")
let spec = document.getElementById("spec")
let date = document.getElementById("date")
let address = document.getElementById("address")
let Gmail = document.getElementById("gmail");

// errors
let Fnameerr = document.querySelector(".addname1")
let Snameerr = document.querySelector(".addname2")
let regnoerr = document.querySelector(".regno")
let depterr = document.querySelector(".dept")
let specerr = document.querySelector(".spec")
let dateerr = document.querySelector(".date")
let adderr = document.querySelector(".address")
let gerr = document.querySelector(".gmail")

let addForm = document.querySelector(".addform");
window.addEventListener("DOMContentLoaded", (() => {
    if (addForm) {
        addForm.addEventListener("submit", ((e) => {
            let i = Namefn();
            let z = SecondNamefn();
            let j = Regno();
            let d = GmailValidate();
            let k = deptfn();
            let l = specfn();
            let m = Datefn();
            let n = addressfn();
            if (i + j + k + l + m + n + d != 7) {
                e.preventDefault();
            }
        }))
    }
}))

function SecondNamefn() {
    if (Sname.value == "") {
        Snameerr.style.display = "block"
        return 0;
    }
    Snameerr.style.display = "none"
    return 1;
}

function Namefn() {
    if (addName.value == "") {
        Fnameerr.style.display = "block"
        return 0;
    }
    Fnameerr.style.display = "none"
    return 1;
}
function Regno() {
    if (regno.value == "") {
        regnoerr.style.display = "block"
        return 0;
    }
    regnoerr.style.display = "none"
    return 1;
}
function GmailValidate() {
    if (Gmail.value == "") {
        gerr.style.display = "block"
        return 0;
    }
    gerr.style.display = "none"
    return 1;
}
function deptfn() {
    if (dept.value == "") {
        depterr.style.display = "block"
        return 0;
    }
    depterr.style.display = "none"
    return 1;
}
function specfn() {
    if (spec.value == "") {
        specerr.style.display = "block"
        return 0;
    }
    specerr.style.display = "none"
    return 1;
}
function Datefn() {
    if (date.value == "") {
        dateerr.style.display = "block"
        return 0;
    }
    dateerr.style.display = "none"
    return 1;
}
function addressfn() {
    if (address.value == "") {
        adderr.style.display = "block"
        return 0;
    }
    adderr.style.display = "none"
    return 1;
}

// Search Validation
let search = document.querySelector(".input");
let searchForm = document.querySelector(".search-form");
console.log(search)
console.log(searchForm)
document.addEventListener("DOMContentLoaded", (() => {
    if (searchForm) {
        searchForm.addEventListener("submit", ((e) => {
            if (search.value == "" || search.value.length < 1) {
                e.preventDefault();
                alert("Enter Valid register number");
            }
        }))
    }
}))
