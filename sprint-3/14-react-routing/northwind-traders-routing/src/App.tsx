import { Route, BrowserRouter as Router, Routes } from 'react-router-dom'
import './App.css'
import CategoriesList from './components/categories/categories-list/CategoriesList'
import CategoryAdd from './components/categories/category-add/CategoryAdd'
import CategoryDetails from './components/categories/category-details/CategoryDetails'
import CategoryEdit from './components/categories/category-edit/CategoryEdit'
import Home from './components/home/Home'
import ProductAdd from './components/products/product-add/ProductAdd'
import ProductDetails from './components/products/product-details/ProductDetails'
import ProductEdit from './components/products/product-edit/ProductEdit'
import ProductSearch from './components/products/product-search/ProductSearch'
import Header from './shared/header/Header'
import CategoriesPage from './components/categories/categories-page/CategoriesPage'
import ProductPage from './components/products/products-page/ProductsPage'

function App() {

  return (
    <>
    <Router>
      <Header />

        <main className='container mt-5'>
          <Routes>
            <Route path='/' element={<Home/>} /> 
            <Route path='/categories' element={<CategoriesPage/>}/>
              <Route path='' element={<CategoriesList/>}/>
              <Route path=':categoryId' element={<CategoryDetails/>}/>
              <Route path='/add' element={<CategoryAdd/>}/>
              <Route path='/edit' element={<CategoryEdit/>}/>
            <Route path='/products' element={<ProductPage/>}/>
              <Route path='' element={<ProductSearch/>}/>
              <Route path=':productId' element={<ProductDetails/>}/>
              <Route path='/add' element={<ProductAdd/>}/>
              <Route path='/edit' element={<ProductEdit/>}/>
          </Routes>
          

          </main>

    </Router>
     








     


    </>
  )
}

export default App
