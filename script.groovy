def buildApp() {
    echo "building the application from Groovy script"
}

def testApp() {
    echo "testing the application from Groovy script"
}

def deploApp() {
    echo "deploying the application from Groovy script"
    echo "deploying version ${params.VERSION}"
}

return this
