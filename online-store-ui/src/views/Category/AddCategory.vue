<template>
  <div class="container">
    <div class="row">
      <div class="col-12 text-center">
        <h3 class="pt-3">Add category</h3>
      </div>
    </div>

    <div class="row">
      <div class="col-3"></div>
      <div class="col-md-6 px-5 px-md-0">
        <form>
          <div class="form-group">
            <label>Category Name</label>
            <input type="text" class="form-control" v-model="categoryName" required>
          </div>
          <div class="form-group">
            <label>Description</label>
            <input type="text" class="form-control" v-model="description" required>
          </div>
          <div class="form-group">
            <label>ImageURL</label>
            <input type="url" class="form-control" v-model="imageURL" required>
          </div>
          <button type="button" class="btn btn-primary">Submit</button>
        </form>
      </div>
      <div class="col-3"></div>
    </div>
  </div>
</template>

<script>
let axios = require('axios');
import swal from 'sweetalert';
export default {
  data(){
    return {
      categoryName : null,
      description : null,
      imageURL : null,
    }
  },
  // props : [],
  methods : {
    async addCategory() {
      const newCategory = {
        categoryName : this.categoryName,
        description : this.description,
        imageURL : this.imageURL
      };

      const baseURL = 'http://localhost:8080/api/categories';


      await axios({
        method: 'post',
        url: baseURL + 'category/create',
        data: JSON.stringify(newCategory),
        headers: {
          'Content-Type': 'application/json'
        }
      }).then(() => {
        // console.log(response);
        swal({
          title: "Success",
          text: "Category added successfully",
          icon: "success",
          closeOnClickOutside: false,
          closeOnEsc: false,
        });
      }).catch(err => console.log(err));
    }
  },
  mounted(){
  }
}
</script>

<style scoped>
h4 {
  font-family: 'Roboto', sans-serif;
  color: #484848;
  font-weight: 700;
}
</style>