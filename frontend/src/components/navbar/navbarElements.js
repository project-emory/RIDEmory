import { FaBars } from "react-icons/fa";
import { NavLink as Link } from "react-router-dom";
import styled from "styled-components";

export const Nav = styled.nav`
    background: #0033a0;
    height: 85px;
    width: 100%;
    display: flex;
    position: fixed;
    top: 0;
    justify-content: space-between;
`;

export const NavLink = styled(Link)`
    color: #fff8e9;
    display: flex;
    align-items: center;
    text-decoration: none;
    padding: 0 1rem;
    height: 100%;
    cursor: pointer;
    &.active {
        color: #d7b75f;
    }
    &:hover {
        color: #b58500;
    }
`;

export const Bars = styled(FaBars)`
    display: none;
    color: #fff8e9;
    @media screen and (max-width: 700px) {
        display: block;
        position: absolute;
        top: 0;
        right: 0;
        transform: translate(-100%, 75%);
        font-size: 1.8rem;
        cursor: pointer;
    }
`;

export const NavMenu = styled.div`
    display: flex;
    align-items: center;
    margin-right: 24px;
    @media screen and (max-width: 700px) {
        display: none;
    }
`;

export const NavBtn = styled.nav`
    display: flex;
    align-items: center;
    margin-right: 24px;
    @media screen and (max-width: 700px) {
        display: none;
    }
`;

export const NavBtnLink = styled(Link)`
    border-radius: 10px;
    background: #007dba;
    padding: 10px 22px;
    text-decoration: none;
    color: #fff8e9;
    outline: none;
    border: none;
    cursor: pointer;
    transition: all 0.15s ease-in-out;
    margin-left: 24px;
    &:hover {
        transition: all 0.15s ease-in-out;
        background: #0f628b;
    }
`;