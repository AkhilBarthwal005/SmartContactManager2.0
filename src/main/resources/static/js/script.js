console.log("Hello from script.js!")


let defaultTheme = "light";

// run applyTheme() when the page loads
document.addEventListener("DOMContentLoaded", function() {
    applyTheme();
});

// add event listener to the theme change button
document.querySelector("#theme_change").addEventListener("click", function() {
    getTheme() === "light" ? setTheme("dark") : setTheme("light");
    applyTheme();
});

// apply the theme
function applyTheme() {
    let theme_change = document.querySelector("#theme_change");
    //update the text of the button
    theme_change.querySelector("span").innerHTML = getTheme() === "light" ? "Dark" : "Light";
    let theme = getTheme();
    let html = document.querySelector("html");
    if (theme === "light") {
        html.classList.remove("dark");
        html.classList.add("light");
        theme_change.querySelector("span").innerHTML = "Dark";
    } else {
        html.classList.remove("light");
        html.classList.add("dark");
        theme_change.querySelector("span").innerHTML = "Light";
    }
}

//set theme to local storage
function setTheme(theme) {
    localStorage.setItem("theme", theme);
}


// get theme from local storage
function getTheme() {
    let theme = localStorage.getItem("theme");
    if (theme === null) {
        return defaultTheme;
    }
    return theme;
}