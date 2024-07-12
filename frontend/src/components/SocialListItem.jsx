import React from 'react';
import '../SocialListItem.css';

const SocialListItem = ({ social }) => {
  function deleteSocial() {
    console.log('deleteSocial activated');
    // Implement deletion logic here
  }

  return (
    <div className="social-item-container">
      
      {social === "email" && (
        <>
          <div className='social-item-info'>
            <div className='icon-container'>
              <img src="/../../public/email.png" alt="Email Icon" className='icon-image' />
            </div>
            
            
            <div>
              <p style={{ marginBottom: '0' }}>ronald.richards@emory.edu</p>
              <p style= {{ marginTop: '0', color: 'gray', fontSize: 'small' }}>Email</p>
            </div>
          </div>
        </>
      )}

      {social === "phone" && (

        
        <>
          <div className='social-item-info'>
            <div className='icon-container'>
              <img src="/../../public/phone-call.png" alt="Email Icon" className='icon-image' />
            </div>
            
            <div>
            <p style={{ marginBottom: '0' }}>(603) 555-0123</p>
            <p style= {{ marginTop: '0', color: 'gray', fontSize: 'small' }}>Phone</p>
            </div>
          </div>
        </>
      )}

      {social === "GroupMe" && (
        <>
          <div className='social-item-info'>
            <div className='icon-container'>
              <img src="/../../public/groupme.png" alt="Email Icon" className='icon-image' />
            </div>
            <div>
              <p style={{ marginBottom: '0'}}>106508340</p>
              <p style={{ marginTop: '0'}}>GroupMe</p>
            </div>
          </div>
        </>
      )}

      <button className="delete-button" onClick={deleteSocial}>Delete</button>
    </div>
  );
};

export default SocialListItem;
