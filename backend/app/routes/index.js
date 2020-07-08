const fs = require("fs")
const path = require("path")

module.exports = app => {
    fs
        .readdirSync(__dirname) // gets all subdirectories and file names from /controllers
        .filter(name => name !== "index.js") // filters to exclude this file (index.js)
        .forEach(name => {
            if (name.indexOf(".js") === -1) { // if name is a folder
                // makes everything again for the folder
                fs
                    .readdirSync(path.resolve(__dirname, name))
                    .filter(folderFile => folderFile.indexOf(".route") !== -1)
                    .forEach(folderFile => require(path.resolve(__dirname, name, folderFile))(app)) // makes the route file require and passes app as a parameter
            } else {
                require(path.resolve(__dirname, name))(app) // makes the route file require and passes app as a parameter
            }
        }) 
}