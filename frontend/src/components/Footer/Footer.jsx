import React from 'react'
import { footerLogo } from '../../assets/images'
import './footer.scss'
import {Button} from '..'

function Footer() {
  return (
    <footer
      className='footer py-10 text-neutral-content bottom-0 w-full mx-auto'>
      <div className='card'>
        <img src={footerLogo} />
        <span className='address'>
        <p>Atlanta - Georgia</p>
        <p>Emory University</p>
        </span>
        <span className='contact'>
        <p>Phone: 404-234-453</p>
        <p>Email: ridemory@gmail.com</p>
        </span>
      </div>

      <div className='card'>
        <span className='font-bold'>Useful Links</span>
        <ul>
          <li><i className="fas fa-thin fa-chevron-right"></i><a className='link link-hover'>Home</a></li>
          <li><i className="fas fa-thin fa-chevron-right"></i><a className='link link-hover'>About Us</a></li>
          <li><i className="fas fa-thin fa-chevron-right"></i><a className='link link-hover'>Our Services</a></li>
          <li><i className="fas fa-thin fa-chevron-right"></i><a className='link link-hover'>Contact Us</a></li>
        </ul>
      </div>
      <div className='card'>
        <span className='font-bold'>Partners</span>
        <ul>
          <li><i className="fas fa-thin fa-chevron-right"></i><a className='link link-hover'>Companies</a></li>
          <li><i className="fas fa-thin fa-chevron-right"></i><a className='link link-hover'>Organisational</a></li>
          <li><Button className='green-btn'>START NOW</Button></li>
        </ul>
      </div>
      <div className='card'>
        <span className='font-bold'>Newsletter</span>
        <div className='form-control'>
          <label className='label'>
            <span className='sub-message'>
              Subscribe to RIDEmory to receive all news and other services
            </span>
          </label>
          <div className='relative'>
            <input
              type='text'
              className='input input-bordered'
            />
            <Button className='blue-btn'>Subscribe</Button>
          </div>
        </div>
      </div>
    </footer>
  )
}

export default Footer
