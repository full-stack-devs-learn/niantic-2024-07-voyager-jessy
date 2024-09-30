import './App.css'
import CategoriesList from './components/categories/categories-list/CategoriesList'
import CategoryAdd from './components/categories/category-add/CategoryAdd'
import CategoryDetails from './components/categories/category-details/CategoryDetails'
import CategoryEdit from './components/categories/category-edit/CategoryEdit'
import ProductAdd from './components/products/product-add/ProductAdd'
import ProductDetails from './components/products/product-details/ProductDetails'
import ProductEdit from './components/products/product-edit/ProductEdit'
import ProductSearch from './components/products/product-search/ProductSearch'
import Header from './shared/header/Header'

function App() {

  return (
    <>
      <Header />
      <main className='container mt-5'>
        <CategoriesList></CategoriesList>
        <CategoryDetails></CategoryDetails>
        <CategoryAdd></CategoryAdd>
        <CategoryEdit></CategoryEdit>

        <ProductSearch></ProductSearch>
        <ProductDetails></ProductDetails>
        <ProductAdd></ProductAdd>
        <ProductEdit></ProductEdit>








      </main>


    </>
  )
}

export default App
