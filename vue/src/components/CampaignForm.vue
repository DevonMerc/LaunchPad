


<template>
    <!-- <div>
        <h1>My unorthodox below, form not finished</h1>
        Thinking a form:
        $ Goal
        Title
        Campaign manager
        Description
        image upload maybe
        radio button for private or public
        dropdown menu for tags set, or its like checkboxes? Gonna struggle with checkbox logic
        submit button
    </div> -->
    <div class="container">
        <h1>Create a New Campaign!</h1>
    <form>
        <div>
            <label for="title">What will you call your campaign? </label>
            <input type="text" id="title" required/>
        </div>
        <div>
            <label for="goal">What is your starting goal? </label>
            <input type="number" id="goal" required/>
        </div>
        <div>
            <label for="about">Describe your campaign: </label>
            <textarea id="about" name="about" rows="8" cols="50" required></textarea>
        </div>
        <div>
            <label for="pic">Upload an image for your campaign: </label>
            <input type="file" id="pic"  accept="image/*"/>
        </div>
        <label for="visibility">Should your campaign be public or private?</label>
        <div class="button-group">
            <label> 
                <input type="radio" name="visibility" value="public" checked> Public
            </label>
            <label>
                <input type="radio" name="visibility" value="private"> Private
            </label>
        </div>
        <input type="submit" @click.prevent="addCampaign" value="Create Campaign"/>
    </form>
</div>
</template>

<script>

export default{ 
    methods: {
        addCampaign(){
            //right now it only redirects to the dashboard, gonna add in store stuff later
            this.$router.push({name:'dashboard'});
        }
    },
   
}
</script>
<style>
h1{
    text-align: center;
}
.container {
    display: flex;
    flex-direction: column;
    justify-content: center;
    height: 100vh;
    padding: 10px;
}
.button-group {
    display: flex;
    justify-content: center;
    margin-bottom: 20px;
}
.button-group label {
    margin-top: 10px;

}

.button-group input[type="radio"] {
   align-content: center;

}
form input[type="text"],
form input[type="number"],
form textarea {
    width: 100%;
    padding: 10px;
    margin-bottom: 15px;
    border: 1px solid #ccc;
    border-radius: 4px;
}
form input[type ="checkbox"]{
    color: green;
}
form input[type="file"]{
    margin: 10px;
    align-content: left;
}
form input[type="submit"]{
    border-color: #23CF68;
    background-color: #23CF68;
}


/* FOR PHONE ONLY VIEW:  */
@media (max-width: 767px) {
form input[type="submit"]{
    width: 100%;
    background-color:#23CF68;
}
}
</style>