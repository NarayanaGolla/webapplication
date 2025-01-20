import React, { useState, useEffect } from 'react';
import '../Popup.css'; // Import CSS for styling
import Popup from 'reactjs-popup';
import 'reactjs-popup/dist/index.css';

const PopupBox = ({ open, onClose, children }) => (
  <Popup open={open} onClose={onClose} position="right center" closeOnDocumentClick>
    <div>
      {children}
    </div>
  </Popup>
);

export default PopupBox;
